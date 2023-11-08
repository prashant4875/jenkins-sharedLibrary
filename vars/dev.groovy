def call( Map propertyInfo ){
    pipeline{
        agent any

        stages{
            stage('Checkout Stage')
                steps{
                    script{
                        echo "${env.Environment}"
                        echo "${env.GithubRepo}"
                    }
                }
        }
    }
}