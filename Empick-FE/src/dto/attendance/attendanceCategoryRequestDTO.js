export default class AttendanceCategoryQueryDTO {
    constructor(
        id = null,
        status = null,
        createdAt = null,
        updatedAt = null
    ) {
        this.id = id;                                    // 카테고리 ID
        this.status = status;                            // 1=출근, 2=퇴근, 3=지각, 4=조퇴 (DB 실제 ID)
        this.createdAt = createdAt;                      // 생성 시각
        this.updatedAt = updatedAt;                      // 수정 시각
    }

    // JSON으로 변환
    toJSON() {
        return {
            id: this.id,
            status: this.status,
            createdAt: this.createdAt,
            updatedAt: this.updatedAt
        };
    }

    // JSON에서 객체 생성
    static fromJSON(json) {
        return new AttendanceCategoryQueryDTO(
            json.id,
            json.status,
            json.createdAt,
            json.updatedAt
        );
    }
}