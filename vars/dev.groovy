def call( Map propertyInfo ){
    pipeline{
        agent any

        stages{
            stage('Checkout Stage') {
                steps{
                    script{
                        echo "${params.Environment}"
                        echo "${params.GithubRepo}"
                    }
                }
            }
        }
    }
}