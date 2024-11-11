const url = 'http://localhost:8080/api/inventory/recalled';
const data = {
    name: 'Recalled Product 1',
    description: 'Defective item recalled due to safety issues',
    dateRecalled: '2023-11-11'
};

fetch(url, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
})
.then(response => {
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json();
})
.then(data => console.log('Response:', data))
.catch(error => console.error('Error:', error));

