import request from "@/utils/request"

export function getAll(page, size, carId = "") {
    return request({
        url: "/info/list",
        method: "get",
        params: {
            page: page,
            size: size,
            carId: carId
        }
    })
}

// export function get(cardId) {
//     return request({
//         url: "/card/card/" + cardId,
//         method: "get"
//     })
// }

export function add(carId) {
    return request({
        url: "/info/in",
        method: "post",
        params: {
            carId: carId
        }
    })
}

export function update(carId) {
    return request({
        url: "/info/out",
        method: "put",
        params: {
            carId: carId
        }
    })
}

export function finish(id) {
    return request({
        url: "/info/finish/" + id,
        method: "put"
    })
}

export function remove(info) {
    return request({
        url: "/info/" + info.infoId,
        method: "delete"
    })
}
