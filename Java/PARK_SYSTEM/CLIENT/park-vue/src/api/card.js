import request from "@/utils/request"

export function getAll(page, size, phone = "") {
    return request({
        url: "/card/list",
        method: "get",
        params: {
            page: page,
            size: size,
            phone: phone
        }
    })
}

export function get(cardId) {
    return request({
        url: "/card/card/" + cardId,
        method: "get"
    })
}

export function getByPhone(phone) {
    return request({
        url: "/card/card",
        method: "get",
        params: {
            phone: phone
        }
    })
}

export function add(card) {
    return request({
        url: "/card/card",
        method: "post",
        data: card
    })
}

export function addMoney(phone, money) {
    return request({
        url: "/card/addMoney",
        method: "post",
        params: {
            phone: phone,
            money: money
        }
    })
}

export function updateAll(card, carIds) {
    return request({
        url: "/card/updateAll",
        method: "put",
        data: card,
        params: {
            carIds: carIds.join(",")
        }
    })
}

export function addAll(card, carIds) {
    return request({
        url: "/card/cardAll",
        method: "post",
        data: card,
        params: {
            carIds: carIds.join(",")
        }
    })
}

export function update(card) {
    return request({
        url: "/card/card",
        method: "put",
        data: card
    })
}

export function remove(card) {
    return request({
        url: "/card/card/" + card.cardId,
        method: "delete"
    })
}
