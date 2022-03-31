import sys
from time import sleep
import pg8000.native as pg

"""Database variables"""
DB_NAME = "docker"
DB_HOST = "logdb"  # Name of docker log db service
DB_PORT = 5432  # Port number exposed by docker log db service
USERNAME = "docker"
PASSWORD = "password"

def init_connection():
    conn = None

    n = 1
    while n < 4:
        try:
            conn = pg.Connection(
                USERNAME,
                host=DB_HOST,
                password=PASSWORD,
                database=DB_NAME,
                port=DB_PORT)
            
            break
        except Exception as e:
            print(f"Connection attempt {n}. Retrying..", flush=True)
            print(e)
            n += 1
    
    if not conn:
        sys.exit(1)
    return conn

def open_connection():
    conn = init_connection()
    return conn