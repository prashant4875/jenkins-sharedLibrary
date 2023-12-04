import com.wm.utils.*

def call(){

    def buildUtils

    pipeline{
        agent any

        parameters{
            choice(name: 'Environment', choices: ['dev', 'sit2'], description: 'The target environment')
            choice(name: 'GithubRepo', choices: ['https://github.com/prashant4875/Netflix-clone'], description: 'Select Github repo to checkout')
            gitParameter(
                name: 'Branch',
                branchFilter: "origin/develop|origin/release.*",
                defaultValue: 'origin/master',
                sortMode: 'DESCENDING_SMART',
                type: 'PT_BRANCH',
                // useRepository: 'https://github.com/prashant4875/Netflix-clone.git'
            )
        }

        stages{
            stage('Checkout Stage') {
                steps{
                    script{
                        echo "${params.Environment}"
                        echo "${params.GithubRepo}"
                        def release_branch = "${params.Branch}"
                        def release = release_branch.substring(7)
                        git branch: release, url: "${params.GithubRepo}"
                        sh "git checkout ${release}"
                    }
                }
            }
            stage('Slave Info'){
                steps{
                    script{
                        common.collectSlaveInfo()
                    }
                }
            }
            stage('Job Details'){
                steps{
                    script{
                        def splitRepo = params.GithubRepo.split('/').last()
                        echo "${splitRepo}"
                        echo "${currentBuild.fullDisplayName},${currentBuild.result},${env.JOB_NAME},${env.BUILD_NUMBER},${env.BUILD_URL}"
                    }
                }
            }
            stage('Build Stage'){
                steps{
                    script{
                        buildUtils = new npm()
                        buildUtils.npmInstall()
                    }
                }
            }
        }
    }
}
