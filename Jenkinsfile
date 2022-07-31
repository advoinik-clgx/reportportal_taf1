pipeline {
    agent {
        label 'master'
    }

    triggers { pollSCM('H */4 * * 1-5') }

    parameters {
        string(name: 'rp.endpoint', defaultValue: 'http://10.114.0.3:8080/')
        string(name: 'RP_LOGIN')
        password(name: 'RP_PASSWORD')
    }

    environment {
        api_token = '578acd15-bf89-4de3-8386-d40e509416d5'
    }

    stages {
        stage('Test') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'rp-superadmin', passwordVariable: 'rp_password', usernameVariable: 'rp_login')]) {
                    sh "./gradlew test  -Drp.endpoint='http://164.92.50.139:8080/' -Ddriver='chrome'"
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