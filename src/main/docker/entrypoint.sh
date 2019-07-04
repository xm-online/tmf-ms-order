#!/usr/bin/env bash
secrets=`ls /run/secrets/ 2>/dev/null |egrep -v '.*_FILE$'`
for s in $secrets
do
    echo "set env $s"
    export "$s"="$(cat /run/secrets/$s)"
done

if [ -n "${APPLICATION_EXTERNAL_CLASSPATH}" ]; then
    echo "
    Found external application classpath ${APPLICATION_EXTERNAL_CLASSPATH}
    app.war will be modified
    Next libs found in external classpath:
    $(ls ${APPLICATION_EXTERNAL_CLASSPATH})
    "
    mkdir /tmp/app
    unzip -qq app.war -d /tmp/app
    cp -vR ${APPLICATION_EXTERNAL_CLASSPATH}/* /tmp/app/WEB-INF/lib
    cd /tmp/app
    zip -r -0 -q - . > /app.war
    rm -rf /tmp/app
    cd /
fi

echo "The application will start in ${JHIPSTER_SLEEP}s..." && sleep ${JHIPSTER_SLEEP}
exec java ${JAVA_OPTS} -Xmx$XMX -XX:+ExitOnOutOfMemoryError -Djava.security.egd=file:/dev/./urandom -jar "app.war" "$@"
