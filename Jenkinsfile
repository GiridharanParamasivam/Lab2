pipeline {
    agent any
    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials-id')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Maven Project') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Docker Login') {
            steps {
                sh 'echo $DOCKER_HUB_CREDENTIALS_PSW | docker login -u $DOCKER_HUB_CREDENTIALS_USR --password-stdin'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t your-docker-hub-username/your-image-name:latest .'
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker push your-docker-hub-username/your-image-name:latest'
            }
        }
    }
}
