pipeline {
    agent {
        docker {
            image 'gradle:7.5.0-jdk18-alpine'
        }
    }

    triggers { pollSCM('H */4 * * 1-5') }

    parameters {
        string(name: 'rp.endpoint', defaultValue: 'http://10.114.0.3:8080/')
        string(name: 'rp.bearer_token')
    }

    environment {
        api_token = '578acd15-bf89-4de3-8386-d40e509416d5'
    }

    stages {
        stage('Test') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'rp-superadmin', passwordVariable: 'rp_password', usernameVariable: 'rp_login')]) {
                    sh "gradle test  -Drp.endpoint='http://164.92.50.139:8080/' -Ddriver='chrome'"
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
    }
}