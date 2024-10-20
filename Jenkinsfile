pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    try {
                        echo 'Checking out the repository...'
                        git branch: 'main', url: 'https://github.com/GiridharanParamasivam/Lab2.git'
                    } catch (Exception e) {
                        echo "Failed to checkout the repository: ${e.message}"
                        currentBuild.result = 'FAILURE'
                        throw e
                    }
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    echo 'Building the application...'
                    // Adjust the build command according to your project's build tool
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    echo 'Running tests...'
                    // Adjust the test command as necessary
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying the application...'
                    // Add your deployment steps here
                    // e.g., sh './deploy.sh'
                }
            }
        }
    }

    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
