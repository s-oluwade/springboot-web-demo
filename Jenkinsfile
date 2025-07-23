pipeline {
  agent { label 'java' }
  
  tools {
    maven 'mvn3.9.11'
  }

  environment {
    GIT_REPO = 'https://github.com/s-oluwade/springboot-web-demo.git'
    CREDENTIALS_ID = 'tomcat-credentials'
    TOMCAT_URL = 'http://172.31.87.48:8081/manager/text'
    WAR_PATH = 'target/*.war' // Adjust if needed
  }

  stages {
    stage('Checkout Code') {
      steps {
        git url: "${GIT_REPO}"
      }
    }

    stage('Build with Maven') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Deploy to Tomcat') {
      steps {
        deploy adapters: [
          tomcat9(
            credentialsId: "${CREDENTIALS_ID}",
            url: "${TOMCAT_URL}",
            path: ''
          )
        ], contextPath: null, war: "${WAR_PATH}"
      }
    }
  }

  post {
    success {
      echo 'Deployment successful!'
    }
    failure {
      echo 'Deployment failed. Check logs.'
    }
  }
}
