node('master') {
	stage('Checkout') {
		checkout([
			'$class' : 'GitSCM',
			branches : scm.branches,
			userRemoteConfigs: scm.userRemoteConfigs,
			extensions: [
				[$class: 'CloneOption', noTags: true, shallow: true, depth: 1, reference: ''],
				[$class: 'CleanBeforeCheckout'],
				[$class: 'CleanCheckout'],
			],
		])
	}
	stage('Build') {
	    env.JAVA_HOME="${tool 'graalvm-ce-java11'}"
	    env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
		//sh "${tool(type : 'maven', name : '3.6.3')}/bin/mvn clean package"
	}
	
	stage('Deploy') {
		sh "${tool(name : 'helm-3.2.4')}/helm version"
	}
}
