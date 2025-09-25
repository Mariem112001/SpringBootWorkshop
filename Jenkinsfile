pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "mariem2001/spring-boot-app"
    }

    stages {
        stage('Push Docker Image') {
            steps {
                script {
                    // Connexion à Docker Hub avec les credentials Jenkins
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
                        sh "docker tag spring-boot-app:latest $DOCKER_IMAGE:latest"
                        sh "docker push $DOCKER_IMAGE:latest"
                    }
                }
            }
        }
    }
}
