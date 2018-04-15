Configure Oracle driver and Datasource

http://www.adam-bien.com/roller/abien/entry/installing_oracle_jdbc_driver_on


http://159.65.117.114:9990/console/
http://159.65.117.114:8080/kitchensink


cd /opt/wildfly-10.1.0.Final/bin
nohup ./standalone.sh 2>&1 > standalone.log &

cd /opt/h2/
add -Dh2.consoleTimeout=500000 to h2.sh
nohup ./h2.sh 2>&1 > h2.log &

