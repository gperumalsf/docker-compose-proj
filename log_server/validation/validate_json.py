import json
from importlib.resources import open_text
from jsonschema import validate, exceptions

def get_schema():
    with open_text(package="validation", resource="schema.json") as f:
        schema = json.load(f)

    return schema

def validate_incoming_json(json_data):
    log_schema = get_schema()

    try:
        validate(instance=json_data, schema=log_schema)
    except exceptions.ValidationError as e:
        print(e)
        return False
    
    return True