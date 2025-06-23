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

async function API_DECOMPACT(){
    let compactURL = document.getElementById("compactURL").value
    /*ChangeURL(await fetch(`http://localhost:3000/URL/get/?compactURL=${compactURL}`))
        .then(res => res.json())
        .then(originalURL => originalURL.originalURL)
        .then(alert(originalURL.originalURL))*/
    console.log(await fetch(`http://localhost:3000/URL/get/?compactURL=${compactURL}`)
        .then(res => res.json())
        .then(originalURL => originalURL.originalURL))
}

function populate(newURL){
    baseURL = ""
    if(!newURL.includes("https")){
        baseURL += "https://"
    }
    if(!newURL.includes("www")){
        baseURL += "www."
    }
    return baseURL
}

function ChangeURL(newURL){
    let finalURL = document.getElementById("finalURL")
    let final = populate(newURL)
    finalURL.innerHTML = final + newURL
    finalURL.href = final + newURL
}