pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Test application') {
            when {
                expression {
                    BRANCH_NAME == 'main' || BRANCH_NAME == 'dev'
                }
            }
            steps {
                script {
                    echo "Test the application"
                }
            }
        }

        stage('Build jar') {
            steps {
                script {
                    echo "Building the application"
                }
            }
        }

        stage('Build image') {
            steps {
                script {
                    echo "Building the docker image"

                }
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying to ..."
            }
        }
    }
}
