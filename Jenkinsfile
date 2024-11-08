pipeline {
    agent any
    environment {
        DOCKER_USERNAME = 'giridharansivam'
        DOCKER_PASSWORD = 'Girisabari1999^@'
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
                        sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                    } else {
                        bat 'docker login -u %DOCKER_USERNAME% -p "%DOCKER_PASSWORD%"'
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
