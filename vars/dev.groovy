def call( Map propertyInfo ){
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
                        git branch: release, url: "${params.GithubRepo}"
                        sh "git checkout ${release}"
                    }
                }
            }
        }
    }
}