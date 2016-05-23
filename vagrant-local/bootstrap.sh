#!/usr/bin/env bash
# update all existing packages
sudo yum -y update
# install wget and dos2unix
sudo yum -y install wget
sudo yum -y install dos2unix
# download java
sudo wget --no-cookies \
--no-check-certificate \
--header "Cookie: oraclelicense=accept-securebackup-cookie" \
"http://download.oracle.com/otn-pub/java/jdk/8u91-b14/jdk-8u91-linux-x64.rpm" \
-O /tmp/jdk-8-linux-x64.rpm
# install java
sudo yum -y install /tmp/jdk-8-linux-x64.rpm
sudo rm /tmp/jdk-8-linux-x64.rpm
# download tomcat8
49
8.5 Create a Vagrantfile QOTD Project Guide - Week 8
sudo wget http://download.nextag.com/apache/tomcat/tomcat-8/v8.0.33/bin/apache-tomcat-8.0.33.tar.gz -P /tmp
# prepare for tomcat8 install
sudo useradd -r tomcat8 --shell /bin/false
# install tomcat8
sudo tar -zxf /tmp/apache-tomcat-8.0.33.tar.gz -C /opt
sudo ln -s /opt/apache-tomcat-8.0.33 /opt/tomcat-latest
sudo chown -hR tomcat8: /opt/tomcat-latest /opt/apache-tomcat-*
sudo rm /tmp/apache-tomcat-8.0.33.tar.gz
# configure tomcat8 to run on boot
sudo dos2unix /tmp/tomcat8
sudo mv /tmp/tomcat8 /etc/init.d/tomcat8
sudo chown root:root /etc/init.d/tomcat8
sudo chmod a+x /etc/init.d/tomcat8
sudo chkconfig --add tomcat8
sudo chkconfig tomcat8 on
# start tomcat the first time
sudo service tomcat8 start
# deploy the application
sudo chown tomcat8:tomcat8 /etc/init.d/tomcat8
sudo mv /tmp/qotd.war /opt/tomcat-latest/webapps/qotd.war
