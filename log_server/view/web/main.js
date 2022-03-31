// // Add some event listener to a web element
// function log_to_server(button, input, websocket) {
//     button.addEventListener("click", ({ target }) => {
//         message = input.value

//         if (!message || message === "") {
//             message = "None"
//         }
//         const event = {
//             timestamp: new Date().toLocaleString(),
//             eventType: 'userEvent',
//             content: message
//         };

//         websocket.send(JSON.stringify(event));
//         console.log(event)
//     });
// }

// // On page load, open a new websocket
// window.addEventListener("DOMContentLoaded", () => {
//     button = document.getElementById('main_button');
//     user_message = document.getElementById('new_input')
//     const startup_event = {
//         "timestamp": new Date().toLocaleString(),
//         "eventType": "serverEvent",
//         "content": "App has started."
//     }
//     console.log(startup_event);

//     const websocket = new WebSocket("ws://localhost:8001/");
//     websocket.onmessage = function (e) { console.log(e.data) }
//     websocket.onopen = () => websocket.send(JSON.stringify(startup_event));

//     log_to_server(button, user_message, websocket);
// });