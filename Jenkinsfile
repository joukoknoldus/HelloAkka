pipeline {
    agent none
    stages {
        stage('Checkout') {
            agent { label 'linux' }
            steps {
                git 'https://github.com/joukoknoldus/HelloAkka.git'
            }
        }
        stage('Build') {
            agent { label 'linux' }
            steps {
                sh "docker build -t hello_akka:v1 ."
                sh "docker tag hello_akka:v1 192.168.1.5:5000/hello_akka"
                
            }
        }
        stage('Commit') {
            agent { label 'linux' }
            steps {
                sh "docker push 192.168.1.5:5000/hello_akka"
            }
        }
        stage('Remove') {
            agent { label 'linux' }
            steps {
                sh "docker image remove hello_akka:v1"
                sh "docker image remove 192.168.1.5:5000/hello_akka"
            }
        }
        stage('Deploy') {
            agent { label 'linux' }
            steps {
                sh "ssh jouko@192.168.1.5 '/usr/bin/nohup /snap/bin/docker run -p 9000:9000 localhost:5000/hello_akka:latest &' &"
            }
        }
    }
}
