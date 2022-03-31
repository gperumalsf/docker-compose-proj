FROM python:3.9.12-alpine3.14

ENV PYTHONPATH "${PYTHONPATH}:root/validation"

COPY . .

RUN pip install -r requirements.txt

EXPOSE 8001 8002 5432

CMD python -m app