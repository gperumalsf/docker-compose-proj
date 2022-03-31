from data_access_layer import db

TABLE_NAME = "logs"

def create_log(payload):
    """Create log in database"""
    conn = db.open_connection()
    sql_prefix = f"INSERT INTO {TABLE_NAME}(timestamp, eventType, content) VALUES"
    sql_payload_tuple = ['None', 'None', 'None']
    for k, v in payload.items():
        if k == 'timestamp':
            sql_payload_tuple[0] = v
        elif k == 'eventType':
            sql_payload_tuple[1] = v
        else:
            sql_payload_tuple[2] = v
    sql_payload_tuple = tuple(sql_payload_tuple)
    sql_final = f'{sql_prefix} {sql_payload_tuple};'

    # Execute db call

    try:
        conn.run(sql_final)
    except Exception as e:
        print("Error inserting logs.", flush=True)
    finally:
        conn.close()


def delete_log(payload):
    """Delete log in database - May not be necessary in an append-only log database"""
    pass