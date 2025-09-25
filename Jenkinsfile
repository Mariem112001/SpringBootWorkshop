
pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'rendu', url: 'https://github.com/Mariem112001/SpringBootWorkshop.git'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t spring-boot-app:latest ."
                }
            }
        }
    }
}
