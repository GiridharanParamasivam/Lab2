pipeline {
    agent any
    environment {
        DOCKER_CREDENTIALS = credentials('docker-hub-credentials-id')
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build Maven Project') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean install'
                    } else {
                        bat 'mvn clean install'
                    }
                }
            }
        }
        stage('Docker Login') {
            steps {
                script {
                    if (isUnix()) {
                        // For Unix/Linux systems
                        sh 'echo $DOCKER_CREDENTIALS_PSW | docker login -u $DOCKER_CREDENTIALS_USR --password-stdin'
                    } else {
                        // For Windows systems
                        bat '''
                            echo %DOCKER_CREDENTIALS_PSW% | docker login -u %DOCKER_CREDENTIALS_USR% --password-stdin
                        '''
                    }
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker build -t giridharansivam/devops_lab2:latest .'
                    } else {
                        bat 'docker build -t giridharansivam/devops_lab2:latest .'
                    }
                }
            }
        }
        stage('Docker Push') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'docker push giridharansivam/devops_lab2:latest'
                    } else {
                        bat 'docker push giridharansivam/devops_lab2:latest'
                    }
                }
            }
        }
    }
}
