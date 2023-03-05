FROM mcr.microsoft.com/mssql/server:2017-latest

RUN mkdir -p /neo_service_worker/config
WORKDIR /neo_service_worker/config

COPY config /neo_service_worker/config

RUN chmod +x /neo_service_worker/config/entrypoint.sh
RUN chmod +x /neo_service_worker/config/setup.sh

ENTRYPOINT ["./entrypoint.sh"]