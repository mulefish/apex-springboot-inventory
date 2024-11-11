const url = 'http://localhost:8080/api/inventory/recalled/1';
const data = {
    name: 'Updated Recalled Product Name',
    expired: true
};

fetch(url, {
    method: 'PUT',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
})
.then(response => {
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json();
})
.then(data => console.log('Updated recalled product:', data))
.catch(error => console.error('Error:', error));
