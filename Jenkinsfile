pipeline {
    agent any

    stages {
  

        stage('Build') {
            steps {
                // Build the project using Maven
              sh 'mvn clean install'
              echo 'Building application...'
            }
        }

        stage('Test') {
            steps {
                // Run unit tests
                //sh 'mvn test'
               echo 'Testing application...'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the application (placeholder)
                echo 'Deploying application...'
            }
        }
    }


}

