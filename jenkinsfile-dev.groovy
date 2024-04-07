@Library('shared-library') _
pipeline{
    agent any
    stages{
        stage('Demo stage'){
            steps{
                    new()
            }
        }
    }
}