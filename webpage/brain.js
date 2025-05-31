async function GETAPI(originalURL){
    let reply = await fetch(`http://localhost:3000/URL/generateCompact/?originalURL=${originalURL}`).then(res => res.json()).then(compactURL => console.log(compactURL.compactURL))
    return reply
}

async function API_COMPACT(){
    let originalURL = document.getElementById("originalURL").value
    ChangeURL(await fetch(`http://localhost:3000/URL/generateCompact/?originalURL=${originalURL}`)
        .then(res => res.json())
        .then(compactURL => compactURL.compactURL))
}

function API_DECOMPACT(){
    let compactURL = document.getElementById("compactURL").value
    ChangeURL(compactURL)
}

function ChangeURL(newURL){
    let finalURL = document.getElementById("finalURL")
    baseURL = ""
    if(!newURL.includes("https")){
        baseURL += "https://"
    }
    if(!newURL.includes("www")){
        baseURL += "www."
    }
    finalURL.innerHTML = baseURL + newURL
    finalURL.href = baseURL + newURL
}