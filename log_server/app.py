import sys
import asyncio
import websockets
from validation.validate_json import validate_incoming_json, json
from data_access_layer.crud import create_log

WEBSOCKET_PORT = 8001

async def handler(websocket):
    while True:
        try:
            message = await websocket.recv()
            message = json.loads(message)
        except websockets.ConnectionClosedOK:
            break
        except websockets.ConnectionClosedError:
            print("Some connection issue", flush=True)
            sys.exit(1)

        if not validate_incoming_json(message):
            print("Incoming log message is invalid!", flush=True)
        else:
            # Write log to database
            create_log(message)
            print(message, flush=True)

async def main():
    async with websockets.serve(handler, "", WEBSOCKET_PORT):
        # Run forever
        try:
            await asyncio.Future()
        except asyncio.Future.Exception as e:
            print(e)

if __name__ == "__main__":
    print(f"Listening on port {WEBSOCKET_PORT}", flush=True)
    asyncio.run(main())
