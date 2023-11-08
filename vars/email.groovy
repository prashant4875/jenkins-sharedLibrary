def call(emailTo, 
        emailFrom, 
        displayName, 
        result, 
        jobName, 
        buildNumber, 
        buildUrl) {
    emailext (
            to: emailTo,
            from: emailFrom,
            subject: "This is a build for ${displayName}:${result}",
            body: """
                <p> EXECUTED: Job <b>\'SUCCESS ${jobName}:${buildNumber}\'
                </b></p><p> View Console output at "<a href="${buildUrl}">
                ${jobName}:${buildNumber}</a>"</p>
                <p><i>(Build log is attached)</i></p>
            """,
            compressLog: 'true',
            attachLog: 'true'
    )
}
