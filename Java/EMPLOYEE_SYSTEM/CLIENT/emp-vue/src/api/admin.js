import request from "@/utils/request"


export function login(data) {
    return request({
        url: "/admin/login",
        method: "post",
        data: data
    })
}

export function changePass(data) {
    return request({
        url: "/admin/changePass",
        method: "post",
        data: data
    })
}
