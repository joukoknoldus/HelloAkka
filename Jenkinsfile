pipeline {
	agent { label 'linux' }
	tools {
		org.jvnet.hudson.plugins.SbtPluginBuilder1.1.6
	}
	stages {
		stage('checkout') {
			steps {
				'git https://github.com/joukoknoldus/HelloAkka.git'
			}
		}
		stage('Build') {
			steps {
				sh 'sbt clean compile'
			}		
		}
		stage('Package') {
			steps {
				sh 'sbt clean package'
			}
		}
	}
}
