import com.wm.utils.*

def call(){

    def buildUtils

    pipeline{
        agent any

        stages{
            stage('Checkout Stage') {
                steps{
                    script{
                        echo "${params.Environment}"
                        echo "${params.GithubRepo}"
                        def release_branch = "${params.Branch}"
                        def release = release_branch.substring(7)
                        git branch: 'develop', url: "${params.GithubRepo}"
                        sh "git checkout develop"
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
