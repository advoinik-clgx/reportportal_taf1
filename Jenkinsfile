pipeline {
    agent {
        label 'master'
    }

    options {
        ansiColor('xterm')
    }

    triggers { pollSCM('H/5 * * * *') }

    parameters {
        choice(name: 'browser', choices: ['firefox', 'chrome'])
        string(name: 'rp_endpoint', defaultValue: 'http://10.114.0.3:8080/')
        string(name: 'rp_bearer_token')
    }

    stages {
        stage('Test') {
            tools {
                jdk "openjdk-17"
            }
            steps {
                sh "chmod +x gradlew"
                sh "./gradlew clean test -Drp_endpoint=${rp_endpoint} -Dweb_driver=$browser --info"
            }
        }
    }
    post {
        always {
            allure results: [
                    [path: 'build/allure-results']
            ]
        }
    }
}