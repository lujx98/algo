from typing import List


class Solution:
    def topStudents(self, positive_feedback: List[str], negative_feedback: List[str], report: List[str], student_id: List[int], k: int) -> List[int]:
        positive = set()
        negative = set()
        for str in positive_feedback:
            positive.add(str)
        for str in negative_feedback:
            negative.add(str)
