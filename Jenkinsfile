pipeline {
    agent any

    tools {
        maven 'Maven_3.8.1'  // Ensure Maven is installed and configured in Jenkins
    }

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-11-openjdk-amd64"  // Update based on your system
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from SCM (e.g., GitHub)
                git url: 'https://github.com/GiridharanParamasivam/Lab2.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Clean and compile the Maven project
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Run unit tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the Maven project into a JAR or WAR
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Optional: Deploy to a test environment or artifact repository (e.g., Nexus)
                sh 'mvn deploy'
            }
        }
    }

    post {
        success {
            echo "Build and deployment successful: ${env.BUILD_ID}"
        }
        failure {
            echo "Build failed. Check logs for details."
        }
    }
}
