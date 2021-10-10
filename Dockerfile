FROM postgres
RUN localedef -i de_DE -c -f UTF-8 -A /usr/share/locale/locale.alias de_DE.UTF-8
EXPOSE 5430

ENV POSTGRES_PASSWORD="study"
ENV POSTGRES_USER="study"
ENV POSTGRES_DB="actions-study"
ENV LANG de_DE.utf8
