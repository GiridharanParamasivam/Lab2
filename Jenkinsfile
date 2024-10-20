pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from SCM (Git)
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Run Maven commands using Windows batch
                bat 'mvn clean install'
            }
        }
    }
}
