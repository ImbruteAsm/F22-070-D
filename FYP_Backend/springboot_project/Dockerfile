FROM java8/alpine:latest
RUN apk update \
&& apk upgrade \
&& apk add --no-cache bash \
&& apk add --no-cache --virtual=build-dependencies unzip \
&& apk add --no-cache curl \
&& apk add --no-cache openjdk8-jre
RUN apk add --no-cache python3 \
&& python3 -m ensurepip \
&& pip3 install --upgrade pip setuptools \
&& rm -r /usr/lib/python*/ensurepip && \
if [ ! -e /usr/bin/pip ]; then ln -s pip3 /usr/bin/pip ; fi && \
if [[ ! -e /usr/bin/python ]]; then ln -sf /usr/bin/python3 /usr/bin/python; fi && \
rm -r /root/.cache
RUN apk add nmap nmap-scripts bind-tools jq
RUN pip install --trusted-host pyopenssl json2html
RUN mkdir -p /cai-organizational-risk-analysis/ssh-audit-2.5.0
RUN mkdir -p /cai-organizational-risk-analysis/ssl-checker
RUN mkdir -p /cai-organizational-risk-analysis/resources
COPY ssh-audit-2.5.0 /cai-organizational-risk-analysis/ssh-audit-2.5.0
COPY ssl-checker /cai-organizational-risk-analysis/ssl-checker
COPY target/*.jar  /cai-organizational-risk-analysis
COPY src/main/resources/  /cai-organizational-risk-analysis/resources
COPY src/main/resources/* /cai-organizational-risk-analysis/
COPY start-cai-organizational-risk-analysis.sh /cai-organizational-risk-analysis
RUN chmod a+x /cai-organizational-risk-analysis/start-cai-organizational-risk-analysis.sh
RUN apk update && apk add tzdata
RUN cp /usr/share/zoneinfo/Asia/Karachi /etc/localtime
RUN echo "Asia/Karachi" >  /etc/timezone
RUN echo date
VOLUME /cai-organizational-risk-analysis
WORKDIR /cai-organizational-risk-analysis
CMD "./start-cai-organizational-risk-analysis.sh"
