import request from "@/utils/request"

export function update(charge) {
    return request({
        url: "/charge/charge",
        method: "put",
        data: charge
    })
}

export function getAll(){
    return request({
        url: "/charge/charge",
        method: "get"
    })
}