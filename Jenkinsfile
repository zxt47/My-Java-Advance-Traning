agent any
pipeline {
   stages {
           stage('Build') {
               steps {
                   sh '''
                    echo "WorkSpace:${WORKSPACE}"
                   '''
               }
           }
           stage('UnitTest') {
               steps {

                   sh '''
                   echo "========executing UT========"
                   echo "---------执行单元测试----------"
                   mvn clean test
                   '''
               }
           }
       }
       post {
       	    success {
                //    emailext(
                //        attachLog:false,
                //        subject: '${ENV, var="JOB_NAME"}-第${BUILD_NUMBER}次构建日志',
       			// 	body: '${FILE,path="/opt/app/jenkins/template/email.html"}',
       			// 	to: env.GIT_EMAIL
       			// )
                   //清空target目录
                   sh '''
                   mvn clean
                   sleep 5
                   '''
       		}
       		aborted {

       		}
               failure {

       		    // emailext(
                //        attachLog:false,
                //        subject: '${ENV, var="JOB_NAME"}-第${BUILD_NUMBER}次构建日志',
       			// 	body: '${FILE,path="/opt/app/jenkins/template/email.html"}',
       			// 	to: env.GIT_EMAIL
       			// )
                   //清空target目录
                   sh '''
                   mvn clean
                   sleep 5
                   '''
       		}
       	}
}
