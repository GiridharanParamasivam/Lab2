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
                        // Unix/Linux systems with --password-stdin
                        sh 'echo $DOCKER_CREDENTIALS_PSW | docker login -u "$DOCKER_CREDENTIALS_USR" --password-stdin'
                    } else {
                        // Windows systems with -p flag
                        bat '''
                            docker login -u "%DOCKER_CREDENTIALS_USR%" -p "%DOCKER_CREDENTIALS_PSW%"
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
