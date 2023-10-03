def call(emailTo, emailFrom, displayName, result, jobName, buildNumber, buildUrl) {
    emailext (
            to: emailTo,
            from: emailFrom,
            subject: "This is a build for ${displayName}:${result}",
            body: """
                JenkinsBuild: ${jobName}\n
                BuildNumber: ${buildNumber}\n
                BuildUrl: ${buildUrl}
            """
    )
}
