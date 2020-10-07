namespace java.swift org.exampledriven
namespace java org.exampledriven.auth

exception SomeException {
    1: string code
}

exception UnauthorizedException {
    1: string reason
}

struct SomeReturnData {
    1: string someStringField,
    2: i32 someIntField
}

struct RequestData {
    1: string someStringField,
    2: i32 someIntField
}

struct AuthToken {
    1: string token,
    2: i32 checksum
}

struct UserData {
    1: string id
}


service InternalTestService {
    SomeReturnData getSomeData(
        1: UserData userData,
        2: RequestData requestData
    ) throws (1: SomeException e);
}

service ExternalTestService {
    SomeReturnData getSomeData(
        1: AuthToken authData,
        2: RequestData requestData
    ) throws (1: SomeException e, 99: UnauthorizedException ue);
}
