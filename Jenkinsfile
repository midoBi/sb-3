pipeline {
  
  agent any
   
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Test') {
      steps {
        echo 'testing the application ...'
      }
    }
    stage('Deploy') {
      steps {
        echo 'deploying the application ...'
      }
    }
  }
  post {
    always {
      
    }
    success {
      
    }
    failure {
      
    }
  }
}
