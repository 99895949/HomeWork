import request from "@/utils/request"

export function get(carId) {
    return request({
        url: "/car/car/" + carId,
        method: "get"
    })
}

export function add(car) {
    return request({
        url: "/car/car",
        method: "post",
        data: car
    })
}

export function update(car) {
    return request({
        url: "/car/car",
        method: "put",
        data: car
    })
}

export function remove(card) {
    return request({
        url: "/card/card/" + card.cardId,
        method: "delete"
    })
}


