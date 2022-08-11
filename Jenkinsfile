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
    }

    stages {
        stage('Test') {
            tools {
                jdk "openjdk-17"
            }
            steps {
                withCredentials([usernamePassword(
                        credentialsId: 'api_user',
                        passwordVariable: 'rp_api_password',
                        usernameVariable: 'rp_api_user')]) {
                    sh "chmod +x gradlew"
                    sh "./gradlew clean test -Drp_endpoint=${rp_endpoint} -Dweb_driver=$browser --info"
                }
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