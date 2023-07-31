
def gv

pipeline {

    agent any
    environment {

        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credential')
    }

    parameters {
        string(name: 'MODULES', defaultValue: 'module1,module2', description: 'A comma-separated list of modules to build and test')
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.2', '1.0.3'], description: 'A comma-separated list of modules to build and test')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }

    tools {
        maven 'maven-3.9'
    }
    stages {
        stage('Init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('Test') {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'deploying the application ...'
                echo "deploying with ${SERVER_CREDENTIALS}"
/*
                withCredentials([
                        usernamePassword(credentials: 'server-credential', usernameVariable: USER, passwordVariable: PWD)
                ]) {
                    echo "some script ${USER} ${PWD}"
                }
 */

                echo "deploying version ${params.VERSION}"
            }
        }
    }
}
